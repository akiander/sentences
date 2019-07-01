package com.example.sentences

import java.text.MessageFormat
import java.util.*

class SentenceGenerator {

    internal var nouns = ArrayList<String>()
    internal var verbsPast = ArrayList<String>()
    internal var verbsPresent = ArrayList<String>()
    internal var adjectives = ArrayList<String>()
    internal var prepositions = ArrayList<String>()

    constructor() {

        load(false)
    }

    private fun load(force: Boolean) {

        if (force || nouns.size <= 0) {
            nouns.clear()
            verbsPast.clear()
            verbsPresent.clear()
            adjectives.clear()
            prepositions.clear()

            val nounArray = arrayOf("football", "dog", "yard", "toe", "pickle jar", "home", "butter", "John", "apple pie", "elephant", "slug")
            val verbArrayPast = arrayOf("threw", "ran", "yelled", "sat", "visited", "burped", "kicked", "hugged", "threw up", "ran away from")
            val verbArrayPresent = arrayOf("throw", "run", "yell", "sit", "visit", "burp", "kick", "hug", "throw up", "run away from")
            val adjectiveArray = arrayOf("lucky", "purple", "tiny", "polka-dotted", "greasy", "silly", "gross", "slimy", "smelly", "silky", "obnoxious")
            val prepositionArray = arrayOf("in", "on", "at", "towards", "into", "through", "by", "with")

            for (noun in nounArray) {
                nouns.add(noun)
            }

            for (verb in verbArrayPast) {
                verbsPast.add(verb)
            }

            for (verb in verbArrayPresent) {
                verbsPresent.add(verb)
            }

            for (adjective in adjectiveArray) {
                adjectives.add(adjective)
            }

            for (preposition in prepositionArray) {
                prepositions.add(preposition)
            }
        }
    }

    val sentence: String
        get() = MessageFormat.format("The {0} {1} {2} the {3} {4}", noun, getVerb(Tense.PAST), preposition, adjective, noun)

    val noun: String
        get() {
            load(false)
            val index = Random().nextInt(nouns.size)
            return nouns[index]
        }

    val adjective: String
        get() {
            load(false)
            val index = Random().nextInt(adjectives.size)
            return adjectives[index]
        }

    val preposition: String
        get() {
            load(false)
            val index = Random().nextInt(prepositions.size)
            return prepositions[index]
        }

    fun getVerb(tense: Tense?): String {

        if (tense == null) throw IllegalArgumentException("tense")

        load(false)
        var index: Int

        when (tense) {
            Tense.PAST -> {
                index = Random().nextInt(verbsPast.size)
                return verbsPast[index]
            }
            Tense.PRESENT -> {
                index = Random().nextInt(verbsPresent.size)
                return verbsPresent[index]
            }
            Tense.FUTURE -> {
                index = Random().nextInt(verbsPresent.size)
                return "will " + verbsPresent[index]
            }
            else -> {
                val error = "Unexpected Tense: $tense"
                throw IllegalArgumentException(error)
            }
        }
    }

}

