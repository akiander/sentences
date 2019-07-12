package com.example.sentences

import org.junit.Test

import org.junit.Assert.*

/**
 * SentenceTest, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SentenceGeneratorTests {
    @Test
    fun generateSentenceTest() {
        val worker = SentenceGenerator()
        val sentence = worker.sentence
        assertTrue(sentence.length > 5)
        println(sentence)
    }
}
