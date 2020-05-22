package io.chetan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chetan.dao.RoomDao;
import io.chetan.model.Room;

@Service
public class RoomService 
{

	@Autowired
	private RoomDao roomDao;
	
	//create
	public Room createRoom(Room room)
	{
		System.out.println("\n RoomService () createRoom with room = \n"+room);

		return roomDao.save(room);
	}
	
	//read
	public Room findById(long roomId)
	{
		System.out.println("\n RoomService ()  findById  wht= \n"+roomId);
		 Optional<Room> roomOptional = roomDao.findById(roomId);
		 
		 return roomOptional.get();
	}
	
	//update
	public Room updateRoom(Room room)
	{
		System.out.println("\n RoomService ()  updateRoom with room = \n"+room);

		return roomDao.save(room);
	}
	
	//delete 
	public void deleteRoom(long roomId)
	{
		System.out.println("\n RoomService b4 deleteRoom() with id = \n"+roomId);

		roomDao.deleteById(roomId);
		System.out.println("\n RoomService after deleteRoom() ");
		System.out.println(",roomDao.findById(roomId) = \\n\"+roomDao.findById(roomId));");

	}

	public Room findRoomByRoomNumberAndMyPg(String roomNumber, long roomOfThePg)
	{
		System.out.println("\n RoomService indRoomByRoomNumberAndRoomOfThePg = \n");

		 List<Room> roomsList = roomDao.findRoomByRoomNumberAndMyPg(roomNumber, roomOfThePg);
		 
		 if(roomsList == null || roomsList.size() == 0)
		 {
			 return null ;
		 }
		 else
		 {
			 System.out.println("\n the rooms of the pg = \n"+roomOfThePg+" are as follows =\n ");
			 roomsList.forEach(System.out::println);
			 
			 return roomsList.get(0);
		 }
		 
	}
}
