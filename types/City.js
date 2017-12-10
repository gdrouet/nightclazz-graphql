const BaseAddress = require('./BaseAddress');

class City extends BaseAddress {
    constructor({postcode, city}, coordinates) {
        super(coordinates);
        this.zipCode = postcode;
        this.city = city;
    }

    isTypeOf(value) {
        return value instanceof City;
    }
}

module.exports = City;