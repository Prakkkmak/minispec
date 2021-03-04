package com.company.minispec.visitor;

import com.company.minispec.model.Attribute;
import com.company.minispec.model.Entity;
import com.company.minispec.model.Model;


public interface IVisitor {
    void visitEntity(Entity entity);
    void visitModel(Model model);
    void visitAttribute(Attribute attribute);
}
