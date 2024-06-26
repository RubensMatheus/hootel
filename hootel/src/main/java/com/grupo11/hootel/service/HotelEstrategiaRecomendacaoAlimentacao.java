package com.grupo11.hootel.service;

import com.grupo11.hootel.entity.Alimentacao;
import com.grupo11.hootel.entity.AlimentacaoHotel;
import com.grupo11.hootel.entity.Reserva;
import com.grupo11.hootel.entity.ReservaHotel;
import com.grupo11.hootel.entity.enums.PreferenciaAlimentarHotel;

import java.util.ArrayList;
import java.util.List;

public class HotelEstrategiaRecomendacaoAlimentacao implements EstrategiaRecomendacaoAlimentacao {

    @Override
    public List<Alimentacao> recomendarAlimentacao(List<Alimentacao> alimentacoes, Reserva reserva) {
        if (reserva instanceof ReservaHotel) {
            ReservaHotel reservaHotel = (ReservaHotel) reserva;
            List<Alimentacao> recomendados = new ArrayList<>();

            for (Alimentacao alimentacao : alimentacoes) {
                if (alimentacao instanceof AlimentacaoHotel) {
                    AlimentacaoHotel alimentacaoHotel = (AlimentacaoHotel) alimentacao;

                    boolean podeSerRecomendado = true;
                    for (PreferenciaAlimentarHotel preferencia : reservaHotel.getPreferenciasAlimentares()) {
                        if (!alimentacaoHotel.getCategorias().contains(preferencia)) {
                            podeSerRecomendado = false;
                            break;
                        }
                    }

                    if(podeSerRecomendado) {
                        recomendados.add(alimentacao);
                    }
                }

            }

            return recomendados;
        } else {
            return new ArrayList<>();
        }
    }

}