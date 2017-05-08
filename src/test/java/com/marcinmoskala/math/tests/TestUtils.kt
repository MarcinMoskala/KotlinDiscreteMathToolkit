package com.marcinmoskala.math.tests

internal fun <T> assertIsThrowingError(f: () -> T) {
    try {
        f()
    } catch (r: Error) {
        return
    }
    assert(false)
}