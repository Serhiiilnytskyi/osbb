//package com.lits.osbb.service;
//
//import com.lits.osbb.repository.UserRepository;
//import com.lits.osbb.service.impl.UserServiceImpl;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.modelmapper.ModelMapper;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class userServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private ModelMapper modelMapper;
//
//    @InjectMocks
//    UserService userService = new UserServiceImpl();
//
//    @Test
//    public void shouldFindOneUser {
//        Person person = new Person();
//        PersonDto personDto = new PersonDto();
//
//        person.setIsDead(false);
//        when(personRepository.findById(1L).get()).thenReturn(person);
//        when(modelMapper.map(person, PersonDto.class)).thenReturn(personDto);
//
//        assertEquals(personDto, alivePersonService.getById(1L));
//        verify(personRepository).findById(1L).get();
//    }
//}
