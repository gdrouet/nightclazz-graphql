const rp = require('request-promise-native');

module.exports = {
    create: async (addokQuery) => {
        const result = await rp(addokQuery);
        if (result.features.length == 0) {
            throw new Error("Not found");
        } else {
            const address = result.features[0];
            return address;
        }
    }
};