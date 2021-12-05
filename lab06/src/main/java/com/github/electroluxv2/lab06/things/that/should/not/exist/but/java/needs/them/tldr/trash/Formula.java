package com.github.electroluxv2.lab06.things.that.should.not.exist.but.java.needs.them.tldr.trash;

import com.github.electroluxv2.lab06.entities.Credit;
import com.github.electroluxv2.lab06.entities.Installment;

import java.util.List;

public interface Formula {
    List<Installment> calculateInstalments(final Credit credit);
}
