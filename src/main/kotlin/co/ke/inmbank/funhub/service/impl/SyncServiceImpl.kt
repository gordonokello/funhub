package co.ke.inmbank.funhub.service.impl

import co.ke.inmbank.funhub.service.SecretSantaService
import co.ke.inmbank.funhub.service.StaffService
import co.ke.inmbank.funhub.service.SyncService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class SyncServiceImpl(
    private val staffService: StaffService,
    private val secretSantaService: SecretSantaService,
): SyncService {
    val logger = LoggerFactory.getLogger(SyncServiceImpl::class.java)
    override fun init() {
//        logger.info("Initializing Staff Data Sync")
//        staffService.syncStaffData()
//        logger.info("Initializing Secret Santa Sync")
//        secretSantaService.setUpSecretSanta(2025)
//        logger.info("initialization complete")
        secretSantaService.test()
    }

}