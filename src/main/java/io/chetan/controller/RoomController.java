package io.chetan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.chetan.model.Room;
import io.chetan.service.RoomService;

@RestController
@RequestMapping(value = "/room")
public class RoomController
{

	@Autowired
	private RoomService roomService;
	
	
	//search by id
	@GetMapping(value = "/findRoomById/{roomId}")
	public Room findRoomById(@PathVariable("roomId") long roomId)
	{
		System.out.println("\n RoomController findRoomById() with id = \n"+roomId);
		
		return roomService.findById(roomId);
	}
	
	//search by roomNumber and its Pgid (roomOfThePg
	@GetMapping(value = "/findRoomByRoomNumberAndMyPg/roomNumber/{roomNumber}/myPg/{myPg}")
	public Room findRoomByRoomNumberAndMyPg(@PathVariable("roomNumber") String roomNumber,
			@PathVariable("myPg") long myPg)
	{
		System.out.println("\n RoomController findRoomByRoomNumberAndRoomOfThePg() with roomNumber = \n"+roomNumber
				+"roomOfThePg = \n "+myPg);
		
		return roomService.findRoomByRoomNumberAndMyPg(roomNumber,myPg);

	}
	
	@PostMapping(value = "/createRoom")
	public Room createRoom(@RequestBody Room room)
	{
		System.out.println("\n RoomController createRoom() with room = \n"+room);
		
		return roomService.createRoom(room);

	}
}
