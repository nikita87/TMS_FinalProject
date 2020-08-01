package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.Event;
import java.util.List;

public interface EventService {

    List<Event> findAll();

    List<Event> findAllByUserId(Long userId);

    Event saveEvent (Event event);

    void deleteEventById (Long eventId);

}
