package api.wikipedia.model

data class MediaWikiAPIResponseModel (
    //val batchcomplete: String,
    //
    val query: Query
)
/**
 * 旧データ
 */
data class Query(
    val pageids: Array<String>,
    val pages: HashMap<String, Property>
) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            javaClass != other?.javaClass -> false
            else -> {
                other as Query
                when {
                    pageids.contentEquals(other.pageids) -> false
                    pages != other.pages -> false
                    else -> true
                }
            }
        }
    }

    override fun hashCode(): Int {
        var result = pageids.contentHashCode()
        result = 31 * result + pages.hashCode()
        return result
    }
}

data class Property(val title: String)
/*
data class Query (val random: Array<Property>) {
    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            javaClass != other?.javaClass -> false
            else -> {
                other as Array<Property>
                random.contentEquals(other)
            }
        }
    }

    override fun hashCode(): Int {
        return random.contentHashCode()
    }
}

data class Property (
    val id: Int,
    val ns: Int,
    val title: String
)*/