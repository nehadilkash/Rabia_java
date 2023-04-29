package com.example.finalproject;

import javax.el.ValueExpression;
        import javax.faces.component.UIComponent;
        import javax.faces.context.FacesContext;
        import javax.faces.convert.Converter;
        import javax.faces.convert.FacesConverter;

@FacesConverter(value = "stateConverter")
public class StateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String state) {
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{computeTax}", ComputeTax.class);

        ComputeTax computeTax = (ComputeTax)vex.getValue(ctx.getELContext());
        return computeTax.getStateTax(state);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object stateTax) {
        return ((StateTax)stateTax).getState().toString();
    }

}