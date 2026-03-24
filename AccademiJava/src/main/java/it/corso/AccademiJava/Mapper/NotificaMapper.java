package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.NotificaDto;
import it.corso.AccademiJava.Model.Notifica;

import java.util.ArrayList;
import java.util.List;

public class NotificaMapper {

    public List<NotificaDto> toDtoList(List<Notifica> notifiche){
        List<NotificaDto> notificaDtos = new ArrayList<>();
        notifiche.forEach(notifica ->  notificaDtos.add(toDto(notifica)));
        return notificaDtos;
    }

    public List<Notifica> toEnityList(List<NotificaDto> notificaDtos){
        List<Notifica> notifiche = new ArrayList<>();
        notificaDtos.forEach(notificaDto ->  notifiche.add(toEnity(notificaDto)));
        return notifiche;
    }

    public NotificaDto toDto(Notifica notifica) {
        NotificaDto notificaDto = new NotificaDto();

        notificaDto.setId(notifica.getId());
        notificaDto.setTitolo(notifica.getTitolo());
        notificaDto.setMessaggio(notifica.getMessaggio());
        notificaDto.setTipo(notifica.getTipo());
        notificaDto.setPriorita(notifica.getPriorita());
        notificaDto.setDataCreazione(notifica.getDataCreazione());
        notificaDto.setLetta(notifica.getLetta());
        notificaDto.setDrone(notifica.getDrone());

        return notificaDto;
    }

    public Notifica toEnity(NotificaDto notificaDto) {
        Notifica notifica = new Notifica();

        notifica.setId(notificaDto.getId());
        notifica.setTitolo(notificaDto.getTitolo());
        notifica.setMessaggio(notificaDto.getMessaggio());
        notifica.setTipo(notificaDto.getTipo());
        notifica.setPriorita(notificaDto.getPriorita());
        notifica.setDataCreazione(notificaDto.getDataCreazione());
        notifica.setLetta(notificaDto.getLetta());
        notifica.setDrone(notificaDto.getDrone());

        return notifica;
    }
}

