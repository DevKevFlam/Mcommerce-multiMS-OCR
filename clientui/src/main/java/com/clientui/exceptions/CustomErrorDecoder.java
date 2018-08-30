package com.clientui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;


public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String invoqueur, Response reponse) {

        if (reponse.status() == 404) {
            if (invoqueur.contains("MicroserviceExpeditionProxy")) {
                return new ExpeditionNotFoundException("Expedition Introuvable !!!");
            } else if (invoqueur.contains("MicroserviceProduitsProxy")) {
                return new ProductNotFoundException("Produit Introuvable !!!");
            }
        } else if (reponse.status() >= 400 && reponse.status() <= 499 && reponse.status() != 404) {
            return new ExpeditionNotFoundException(
                    reponse.status() + invoqueur
            );
        }

        return defaultErrorDecoder.decode(invoqueur, reponse);

    }
}


