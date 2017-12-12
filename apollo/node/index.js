import {ApolloClient} from 'apollo-client';
import {HttpLink} from 'apollo-link-http';
import {InMemoryCache, IntrospectionFragmentMatcher}  from 'apollo-cache-inmemory';
import introspectionQueryResultData from './fragmentTypes.json';
import gql from 'graphql-tag';
import fetch from 'node-fetch';

const fragmentMatcher = new IntrospectionFragmentMatcher({
    introspectionQueryResultData
});
const client = new ApolloClient({
    link: new HttpLink({uri: 'http://localhost:4000/graphql', fetch: fetch}),
    cache: new InMemoryCache({
        fragmentMatcher
    })
});

var query = process.argv.join(" ");

client.query({
    variables: {query : query},
    query: gql`
    fragment antennaFields on NearestAntenna {
        coordinates { latitude longitude }
        generation
        provider
        lastUpdate
        status
        dist
        insee
        city
        addressLabel
    }
    
    query search($query: String!) {
        search(query: $query) {
            __typename
        ... on Street { street city zipCode }
        ... on City { city zipCode }
        ... on HouseNumber { houseNumber street city zipCode }    
        
        nearestAntennaFromOrange: nearestAntenna(provider: ORANGE) {
                ...antennaFields
        }
        
        nearestAntennaFromBouygues: nearestAntenna(provider: BOUYGUES_TELECOM) {
          ...antennaFields
        }
        
        nearestAntennaFromSfr: nearestAntenna(provider: SFR) {
          ...antennaFields
        }
        
        nearestAntennaFromFree: nearestAntenna(provider: FREE) {
          ...antennaFields
        }
      }
    }`})
    .then(data => console.log(JSON.stringify(data, null, 2)))
    .catch(error => console.error(error));