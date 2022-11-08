package com.folksdev.account.model

import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.internal.constraintvalidators.bv.money.CurrencyValidatorForMonetaryAmount
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.Date
import javax.persistence.*

@Entity
data class Transaction (
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account

){
}

enum class TransactionType {
    INITIAL, TRANSFER
}

