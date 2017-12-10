const GPS = require('./GPS');

class NearestAntenna {
    constructor({
        en_service,
        date_maj,
        generation,
        adm_lb_nom,
        coordonnees,
        dist,
        adr_lb_add1,
        code_insee,
        nom_com,
    }) {
        this.status = en_service;
        this.lastUpdate = date_maj;
        this.generation = generation;
        this.provider = adm_lb_nom;
        this.coordinates = new GPS(coordonnees, true);
        this.dist = dist;
        this.addressLabel = adr_lb_add1;
        this.insee = code_insee;
        this.city = nom_com;
    }
}

module.exports = NearestAntenna;