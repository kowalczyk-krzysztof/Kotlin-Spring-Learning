package com.learningapp.learning

import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service
import kotlin.reflect.KClass



@Service
class SequenceService(val operations: MongoOperations) {

    fun next(document: KClass<*>) =
        operations.findAndModify(
            query(Criteria.where("_id").`is`(document.simpleName?.lowercase())),
            Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true),
           Sequence::class.java
        )?.seq ?: 1
}