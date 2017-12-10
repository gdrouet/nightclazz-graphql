const rp = require('request-promise-native');

module.exports = {
    create: (addokQuery) => {
        return rp(addokQuery).then(result => {
            if (result.features.length == 0) {
                throw new Error("Not found");
            } else {
                const address = result.features[0];
                return address;
            }
        });
    }
}