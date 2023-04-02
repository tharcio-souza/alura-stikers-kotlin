interface ContentExtractor {
    val contentList: MutableList<Content>
    fun extractContentList(json: String): List<Content>
}