package io.vaan.kuruma

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@RestController
@RequestMapping("api/v1/cars")
class Controller {

    private val repository: MutableMap<Long, Kuruma> = mutableMapOf()
    private val logger: Logger = LoggerFactory.getLogger(Controller::class.java)

    @PostMapping
    fun create(@RequestBody kuruma: Kuruma) {
        logger.info("create $kuruma")
        val randomId = Random.nextLong(100)
        repository.put(randomId, kuruma.copy(id = randomId))
    }

    @GetMapping
    fun findAll(): Collection<Kuruma> {
        logger.info("findAll")
        return repository.values
    }

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Long): Kuruma? {
        logger.info("findById $id")
        val currentNumberOfWheels: Int? = repository.get(id)?.numberOfWheels
        return repository.get(id)?.copy(numberOfWheels = currentNumberOfWheels!! * 2)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: Long) {
        logger.info("deleteById $id")
        repository.clear()
    }
}
