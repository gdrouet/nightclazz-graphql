class GPS {
    constructor(coordinates, latLon)  {
        if (coordinates.length < 2) {
            throw new Error('No GPS coordinates');
        } else {
            this.longitude = coordinates[latLon ? 1 : 0];
            this.latitude = coordinates[latLon ? 0 : 1];
        }
    }
}

module.exports = GPS;