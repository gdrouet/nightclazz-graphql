const Street = require('./Street');

class HouseNumber extends Street {
    constructor({street, housenumber, postcode, city}, coordinates) {
        super({postcode: postcode, city: city, street: street}, coordinates);
        this.houseNumber = housenumber;
    }

    isTypeOf(value) {
        return value instanceof HouseNumber;
    }
}

module.exports = HouseNumber;