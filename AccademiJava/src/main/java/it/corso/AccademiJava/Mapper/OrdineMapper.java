package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.OrdineDto;
import it.corso.AccademiJava.Model.Ordine;

import java.util.ArrayList;
import java.util.List;

public class OrdineMapper //extends AbstractConverter<Ordine,OrdineDto>
{

    public List<OrdineDto> toDtoList(List<Ordine> ordini){
        List<OrdineDto> ordineDtos = new ArrayList<>();
        ordini.forEach(ordine ->  ordineDtos.add(toDto(ordine)));
        return ordineDtos;
    }

    public List<Ordine>  toEnityList(List<OrdineDto> ordineDtos){
        List<Ordine> ordini = new ArrayList<>();
        ordineDtos.forEach(ordineDto ->  ordini.add(toEnity(ordineDto)));
        return ordini;
    }

    // @Override
    public OrdineDto toDto(Ordine ordine) {
        OrdineDto ordineDto = new OrdineDto();

        ordineDto.setId(ordine.getId());
        ordineDto.setUtente(ordine.getUtente());
        ordineDto.setCosto_totale(ordine.getCosto_totale());
        ordineDto.setNumero_prodotti(ordine.getNumero_prodotti());
        ordineDto.getProdotti().addAll(ordine.getProdotti());

        return  ordineDto;
    }

    // @Override
    public Ordine toEnity(OrdineDto ordineDto) {
        Ordine ordine = new Ordine();

        ordine.setId(ordineDto.getId());
        ordine.setUtente(ordineDto.getUtente());
        ordine.setCosto_totale(ordineDto.getCosto_totale());
        ordine.setNumero_prodotti(ordineDto.getNumero_prodotti());
        ordine.getProdotti().addAll(ordineDto.getProdotti());

        return  ordine;
    }
}
