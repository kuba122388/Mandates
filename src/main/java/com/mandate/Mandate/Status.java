package com.mandate.Mandate;

/**
 * Enum Status reprezentuje możliwe stany mandatu.
 *
 * <p>Enum ten jest używany do określenia bieżącego stanu mandatu
 * w aplikacji i może być wykorzystywany w operacjach zarządzania mandatami,
 * takich jak ich aktywacja lub anulowanie.
 */
public enum Status {
    /**
     * Stan wskazujący, że mandat jest aktywny.
     */
    AKTYWNY,

    /**
     * Stan wskazujący, że mandat został anulowany.
     */
    ANULOWANY
}
