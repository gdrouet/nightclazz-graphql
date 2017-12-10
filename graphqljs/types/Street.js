const City = require('./City');

class Street extends City {
    constructor({street, postcode, city}, coordinates) {
        super({postcode: postcode, city: city}, coordinates);
        this.street = street;
    }

    isTypeOf(value) {
        return value instanceof Street;
    }
}

module.exports = Street;