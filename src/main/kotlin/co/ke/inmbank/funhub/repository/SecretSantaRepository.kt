package co.ke.inmbank.funhub.repository

import co.ke.inmbank.funhub.enums.EmailStatus
import co.ke.inmbank.funhub.model.SecretSantaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SecretSantaRepository: JpaRepository<SecretSantaEntity, Long> {
    fun findByGiverAndYear(giver: Long, year: Int): Optional<SecretSantaEntity>
    @Query(value = "SELECT count(*) FROM SecretSantaEntity ss WHERE ss.year =:year", nativeQuery = false)
    fun findCountByYear(year: Int): Long
    fun findByEmailStatus(emailStatus: EmailStatus): Optional<List<SecretSantaEntity>>
}