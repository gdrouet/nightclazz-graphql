const graphqlHTTP = require('express-graphql');
const { buildSchema } = require('graphql');
const { addResolveFunctionsToSchema } = require('graphql-tools');
const AddressAddokFactory = require('./types/AddressAddokFactory');
const HouseNumber = require('./types/HouseNumber');
const Street = require('./types/Street');
const City = require('./types/City');

// Construct a schema, using GraphQL schema language
const schema = buildSchema(`
  type GPS {
    longitude : Float
    latitude : Float
  }

  enum Provider {
    ORANGE
    FREE
    SFR
    BOUYGUES_TELECOM
  }
  
  interface BaseAddress {
    coordinates: GPS
    city: String
    zipCode: String
    nearestAntenna(generation: String, provider: Provider) : NearestAntenna
  }
  
  type City implements BaseAddress {
    coordinates: GPS
    city: String
    zipCode: String
    nearestAntenna(generation: String, provider: Provider) : NearestAntenna
  }
  
  type Street implements BaseAddress {
    street: String
    coordinates: GPS
    city: String
    zipCode: String
    nearestAntenna(generation: String, provider: Provider) : NearestAntenna 
  }
 
  type HouseNumber implements BaseAddress {
    street: String
    houseNumber: String
    coordinates: GPS
    city: String
    zipCode: String
    nearestAntenna(generation: String, provider: Provider) : NearestAntenna
  }
  
  type NearestAntenna {
    coordinates: GPS
    generation: String
    provider: String
    lastUpdate: String
    status: String
    dist: Int
    addressLabel: String
    city: String
    insee: String
  }

  type Query {
    search(query : String!) : BaseAddress 
  }
`);

// The root provides a resolver function for each API endpoint
const root = {
    search: async ({query}) => {
        const TYPES = {
            municipality : City,
            street : Street,
            housenumber : HouseNumber
        };

        const address = await AddressAddokFactory.create({
            uri: 'https://api-adresse.data.gouv.fr/search/',
            json: true,
            qs: {q: query}
        });


        const clazz = TYPES[address.properties.type];
        return new clazz(address.properties, address.geometry.coordinates);
    }
};

const resolverMap = {
    BaseAddress: {
        __resolveType(obj){
            if (obj.houseNumber) {
                return 'HouseNumber';
            } else if (obj.street) {
                return 'Street';
            } else {
                return 'City';
            }
        }
    },

    Provider: {
        ORANGE: "ORANGE",
        FREE: "FREE",
        SFR: "SFR",
        BOUYGUES_TELECOM: "BOUYGUES TELECOM"
    }
};

addResolveFunctionsToSchema(schema, resolverMap);

module.exports = graphqlHTTP({
    schema: schema,
    rootValue: root,
    graphiql: true,
});