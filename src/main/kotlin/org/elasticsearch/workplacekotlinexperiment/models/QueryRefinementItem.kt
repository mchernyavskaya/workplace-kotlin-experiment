package org.elasticsearch.workplacekotlinexperiment.models

import com.squareup.moshi.Json

/**
 * Specifics regarding how this part of the query was refined
 *
 * @param term The term(s) used for the trigger
 * @param position The start and end position the term(s) exist in the original query
 * @param triggerType The type of trigger created
 * @param triggerFilterType The type of filter created from this trigger
 * @param filter
 */

data class QueryRefinementItem(

    /* The term(s) used for the trigger */
    val term: kotlin.String? = null,

    /* The start and end position the term(s) exist in the original query */
    val position: kotlin.collections.List<java.math.BigDecimal>? = null,

    /* The type of trigger created */
    @Json(name = "trigger_type")
    val triggerType: kotlin.String? = null,

    /* The type of filter created from this trigger */
    @Json(name = "trigger_filter_type")
    val triggerFilterType: kotlin.String? = null,

    @Json(name = "filter")
    val filter: FilterSet? = null
)


