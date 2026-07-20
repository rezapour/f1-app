package me.rezapour.domain.usecase

import me.rezapour.domain.models.ConstructorDomain
import me.rezapour.domain.repository.F1DataRepository
import javax.inject.Inject

class ConstructorUseCase @Inject constructor(private val repository: F1DataRepository) {

    suspend operator fun invoke(): List<ConstructorDomain> {
        return repository.getConstructors()
    }

}