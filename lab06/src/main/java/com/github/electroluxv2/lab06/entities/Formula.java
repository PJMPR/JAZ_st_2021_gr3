package com.github.electroluxv2.lab06.entities;

import java.util.List;

public interface Formula {
    List<Installment> calculateInstalments(final Credit credit);
}
