package org.elasticsearch.workplacekotlinexperiment.models

import java.math.BigDecimal

interface Filter

/**
 * GeoDistanceFilter
 * @param unit
 * @param center
 * @param distance A number representing the distance unit
 */

data class GeoDistanceFilter(
    val unit: GeoUnitEnum,
    val center: GeoPoint,
    val distance: BigDecimal
) : Filter

/**
 * RangeFilter
 *
 * @param from
 * @param to
 */
data class RangeFilter(
    val from: ValueFilter? = null,
    val to: ValueFilter? = null
) : Filter

/**
 * A range filter with a geographic center
 *
 * @param unit
 * @param center
 * @param from
 * @param to
 */
data class GeoRangeFilter(
    val unit: GeoUnitEnum,
    val center: GeoPoint,
    val from: ValueFilter? = null,
    val to: ValueFilter? = null
) : Filter

/**
 * A value to filter on
 *
 */
data class ValueFilter(val s: String) : Filter {
    constructor(n: Double) : this("$n")
}

/**
 * A compound set of filters
 */
data class FilterSet(
    val all: List<Filter> = emptyList(),
    val any: List<Filter> = emptyList(),
    val none: List<Filter> = emptyList()
)




