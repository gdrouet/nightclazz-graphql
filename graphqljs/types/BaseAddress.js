const GPS = require('./GPS');
const NearestAntenna = require('./NearestAntenna');
const rp = require('request-promise-native');
const MAX_ANTENNA_DISTANCE = 1000000000;

const FACETS_FIELDS = {
    provider: 'refine.adm_lb_nom',
    generation: 'refine.generation',
};

class BaseAddress {
    constructor(coordinates) {
        this.coordinates = new GPS(coordinates, false);
    }

    async nearestAntenna(params) {
        const qs = {
            'dataset': 'observatoire_2g_3g_4g',
            'geofilter.distance': this.coordinates.latitude + ',' + this.coordinates.longitude + ',' + MAX_ANTENNA_DISTANCE
        };

        for (const key in params) {
            qs[FACETS_FIELDS[key]] = params[key];
        }

        const result = await rp({
            uri: 'https://data.anfr.fr/api/records/1.0/search/',
            json: true,
            qs: qs
        });

        if (result.records.length == 0) {
            return null;
        }

        const antenna = result.records[0].fields;
        return new NearestAntenna(antenna);
    }
}

module.exports = BaseAddress;