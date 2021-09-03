package org.elasticsearch.workplacekotlinexperiment.models

import kotlin.math.absoluteValue

interface GeoPoint {
    companion object {
        val RX_LAT_LON_STRING = Regex("(\\A\\s*(?<lat>[-+]?\\d*\\.?\\d+)\\s*,\\s*(?<lon>[-+]?\\d*\\.?\\d+)\\s*\\z)")
        val RX_WKT_POINT =
            Regex("(?i-mx:\\A\\s*POINT\\s*\\(\\s*(?<lon>[-+]?\\d*\\.?\\d+)\\s+(?<lat>[-+]?\\d*\\.?\\d+)\\s*\\)\\s*\\z)")
        val RX_GEO_HASH = Regex("(\\A[0-9b-hjkmnp-z]+\\z)")
    }
}

class InvalidGeoPointException(s: String) : IllegalArgumentException(s)

class LatLonPoint(s: String) : GeoPoint {
    init {
        val rx = GeoPoint.RX_LAT_LON_STRING
        if (!s.matches(rx)) {
            throw InvalidGeoPointException("Invalid GeoPoint format. Should match $rx")
        }
    }
}

class WktPoint(s: String) : GeoPoint {
    init {
        val rx = GeoPoint.RX_WKT_POINT
        if (!s.matches(rx)) {
            throw InvalidGeoPointException("Invalid GeoPoint format. Should match $rx")
        }
    }
}

class GeoHashPoint(s: String) : GeoPoint {
    init {
        val rx = GeoPoint.RX_GEO_HASH
        if (!s.matches(rx)) {
            throw InvalidGeoPointException("Invalid GeoPoint format. Should match $rx")
        }
    }
}

class ArrayGeoPoint(intArray: IntArray) : GeoPoint {
    init {
        if (intArray.size != 2) {
            throw InvalidGeoPointException("Invalid GeoPoint format. Array size should be 2")
        }
        if (intArray[0].absoluteValue > 180 || intArray[1].absoluteValue > 180) {
            throw InvalidGeoPointException("Invalid GeoPoint format. Array elements should be numbers between -180 and 180")
        }
    }
}
