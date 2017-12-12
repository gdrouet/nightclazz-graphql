const City = require('./City');

class Street extends City {
    constructor({name, postcode, city}, coordinates) {
        super({postcode: postcode, city: city}, coordinates);
        this.street = name;
    }

    isTypeOf(value) {
        return value instanceof Street;
    }
}

module.exports = Street;