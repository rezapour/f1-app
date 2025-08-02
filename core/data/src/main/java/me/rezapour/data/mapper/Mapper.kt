package me.rezapour.data.mapper

interface Mapper<I,  O> {
    fun map(input: I): O
    fun map(inputs: List<I>): List<O>
}