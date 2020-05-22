package io.chetan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.chetan.model.Room;

public interface RoomDao extends CrudRepository<Room,Long>
{

	List<Room> findRoomByRoomNumberAndMyPg(String roomNumber, long myPg);
}
