package com.tms.rakhubovskiy.service;

import com.tms.rakhubovskiy.model.Event;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface EventService {

    List<Event> findAll();

    List<Event> findAllByUserId(Long userId);

    Event saveEvent (Event event);

    void deleteEventById (Long eventId);

}
