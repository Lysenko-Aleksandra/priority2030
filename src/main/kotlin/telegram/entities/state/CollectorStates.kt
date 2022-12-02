package telegram.entities.state

import domain.entities.Fio
import domain.entities.PhoneNumber
import domain.entities.SelectionIdentifier
import domain.entities.SelectionLetter
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

object FullNameCollectorState {
    @Serializable
    object WaitingForLastName : DialogState

    @Serializable
    data class WaitingForFirstName(val lastName: String) : DialogState

    @Serializable
    data class WaitingForPatronymic(val lastName: String, val firstName: String) : DialogState
}

@Serializable
object OrganizationTypeState : DialogState

object PurchaseDescriptionState {
    @Serializable
    object WaitingForShortJustification : DialogState

    @Serializable
    data class WaitingForSelectionLetter(val shortJustification: String) : DialogState

    @Serializable
    data class WaitingForSelectionIdentifier(
        val shortJustification: String,
        val selectionLetter: SelectionLetter
    ) : DialogState

    @Serializable
    data class WaitingForFullJustification(
        val shortJustification: String,
        val selectionLetter: SelectionLetter,
        val selectionIdentifier: SelectionIdentifier
    ) : DialogState

    @Serializable
    data class WaitingForMaterialValuesNeed(
        val shortJustification: String,
        val selectionLetter: SelectionLetter,
        val selectionIdentifier: SelectionIdentifier,
        val fullJustification: String
    ) : DialogState
}

@Serializable
object PurchasePointState : DialogState

@Serializable
object PurchaseIniciatorState : DialogState


@Serializable
object PurchaseCostState : DialogState


object FinanciallyResponsiblePersonState {
    @Serializable
    object WaitingForFio : DialogState

    @Serializable
    data class WaitingForContactPhoneNumber(val fio: Fio) : DialogState
}

object ResponsibleForDocumentsPersonState {
    @Serializable
    object WaitingForFio : DialogState

    @Serializable
    data class WaitingForContactPhoneNumber(val fio: Fio) : DialogState

    @Serializable
    data class WaitingForEmail(
        val fio: Fio, val contactPhoneNumber: PhoneNumber
    ) : DialogState
}

@Serializable
object PurchaseObjectState : DialogState

@Serializable
object PurchaseInitiatorDepartmentState : DialogState

object PurchaseDeadlineAndDeliveryAddressState {
    @Serializable
    object WaitingForDeadline : DialogState

    @Serializable
    data class WaitingForDeliveryAddress(val deadline: LocalDate) : DialogState
}

@Serializable
object MaterialObjectNumberState : DialogState

@Serializable
object TermOfPaymentState : DialogState