package co.ke.inmbank.funhub.util

fun splitName(fullName: String): Pair<String?, String?> {
    val parts = fullName.split(" ")
    val firstName = parts.firstOrNull()
    val otherNames = parts.drop(1).joinToString(" ")
    return Pair(firstName, otherNames)
}