package sbjp.rest.sbjprestful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbjp.rest.sbjprestful.payload.request.GMemberRequest;
import sbjp.rest.sbjprestful.payload.request.GroupRequest;
import sbjp.rest.sbjprestful.payload.response.GroupReponse;
import sbjp.rest.sbjprestful.services.GMemberService;
import sbjp.rest.sbjprestful.services.GroupService;

@CrossOrigin(origins = "http://localhost:6661/")
@RestController(value = "groupAPIofWeb")
@RequestMapping("/api/v1/groups")
public class GroupController {

	@Autowired
	private GroupService groupService;


	@Qualifier("GMemberServiceImpl")
	@Autowired
	private GMemberService gMemberService;

	@GetMapping()
	public ResponseEntity<List<GroupReponse>> getAll() {
		try {
			return new ResponseEntity<>(groupService.getAll(), HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody GroupRequest groupRequest) {
		try {
			if (groupService.add(groupRequest)) {
				return new ResponseEntity<>("Created!", HttpStatus.CREATED);
			}
			return new ResponseEntity<>("Create faile!", HttpStatus.BAD_GATEWAY);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/addMember/{groupId}")
	public ResponseEntity<?> addMember(@PathVariable("groupId") int groupId,
			@RequestBody GMemberRequest gMemberRequest) {
		try {

			if (gMemberService.add(groupId, gMemberRequest)) {
				return new ResponseEntity<>("Created!", HttpStatus.CREATED);
			}
			return new ResponseEntity<>("Create faile!", HttpStatus.BAD_GATEWAY);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{groupId}")
	public ResponseEntity<String> update(@PathVariable("groupId") int groupId, @RequestBody GroupRequest request) {
		try {
			if (groupService.findById(groupId) == null) {
				return new ResponseEntity<>("No group found!", HttpStatus.BAD_GATEWAY);
			}

			if (groupService.update(groupId, request)) {
				return new ResponseEntity<>("Updated!", HttpStatus.OK);
			}
			return new ResponseEntity<>("Update faile!", HttpStatus.BAD_GATEWAY);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{groupId}")
	public ResponseEntity<String> delete(@PathVariable("groupId") int groupId) {
		try {
			if (groupService.findById(groupId) == null) {
				return new ResponseEntity<>("No group found!", HttpStatus.BAD_GATEWAY);
			}

			if (groupService.delete(groupId)) {
				return new ResponseEntity<>("Deleted!", HttpStatus.OK);
			}
			return new ResponseEntity<>("Delete faile!", HttpStatus.BAD_GATEWAY);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
