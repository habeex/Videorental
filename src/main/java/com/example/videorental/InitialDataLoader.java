package com.example.videorental;

import com.example.videorental.enumType.VideoGenre;
import com.example.videorental.enumType.VideoType;
import com.example.videorental.model.Video;
import com.example.videorental.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private VideoRepository videoRepository;
	private boolean hasBeenSetup;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (hasBeenSetup) {
			return;
		}

		createVideoIfNotFound();
		hasBeenSetup = true;
	}


	private void createVideoIfNotFound() {
		List<Video> horrors = videoRepository.findByTitleAndGenre("Spiral: From the Book of Saw", VideoGenre.Horror);
		if (horrors.size() == 0) {
			Video horror = new Video();
			horror.setTitle("Spiral: From the Book of Saw");
			horror.setDescription("Working in the shadow of an esteemed police veteran, brash Detective Ezekiel \"Zeke\" Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city's gruesome past. Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer's morbid game.");
			horror.setGenre(VideoGenre.Horror);
			horror.setType(VideoType.NewRelease);
			horror.setReleasedYear(2021);
			horror.setAge(19);
			horror.setRate(15);
			videoRepository.save(horror);
		}

		List<Video> actions = videoRepository.findByTitleAndGenre("Doom at Your Service", VideoGenre.Action);
		if (actions.size() == 0) {
			Video action = new Video();
			action.setTitle("Doom at Your Service");
			action.setDescription("Dong Kyung has been working hard ever since her parents passed away. Her life seems to get stable after working as an web novel editor for 6 years, but one day she gets diagnosed with brain cancer. She blames her unlucky life and wishes to curse everything to disappear, which unintentionally calls Myul Mang, a messenger between humans and gods, to appear. He says that he can grant her wishes. As her last hope, she makes a contract with Myul Mang for hundred days to live as how she wants, risking her everything.");
			action.setGenre(VideoGenre.Action);
			action.setType(VideoType.Regular);
			action.setReleasedYear(2019);
			action.setAge(18);
			action.setRate(10);
			videoRepository.save(action);
		}

		List<Video> comedys = videoRepository.findByTitleAndGenre("Friends: The Reunion", VideoGenre.Comedy);
		if (comedys.size() == 0) {
			Video comedy = new Video();
			comedy.setTitle("Friends: The Reunion");
			comedy.setDescription("The cast of Friends reunites for a once-in-a-lifetime celebration of the hit series, an unforgettable evening filled with iconic memories, uncontrollable laughter, happy tears, and special guests.");
			comedy.setGenre(VideoGenre.Comedy);
			comedy.setType(VideoType.Regular);
			comedy.setReleasedYear(2018);
			comedy.setAge(19);
			comedy.setRate(10);
			videoRepository.save(comedy);
		}

		List<Video> dramas = videoRepository.findByTitleAndGenre("The Water Man", VideoGenre.Drama);
		if (dramas == null) {
			Video drama = new Video();
			drama.setTitle("The Water Man");
			drama.setDescription("Working in the shadow of an esteemed police veteran, brash Detective Ezekiel \"Zeke\" Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city's gruesome past. Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer's morbid game.");
			drama.setGenre(VideoGenre.Drama);
			drama.setType(VideoType.Children);
			drama.setReleasedYear(2015);
			drama.setAge(10);
			drama.setRate(8);
			videoRepository.save(drama);
		}

		List<Video> romances = videoRepository.findByTitleAndGenre("My Birthday Romance", VideoGenre.Romance);
		if (romances.size() == 0) {
			Video romance = new Video();
			romance.setTitle("My Birthday Romance");
			romance.setDescription("Callie Fitzgerald is tired of her family fixing her up and questioning her single status. She is determined to find a pretend boyfriend for her 35th birthday party just so her family will leave her alone. What she didn't expect was to actually fall for him.");
			romance.setGenre(VideoGenre.Romance);
			romance.setType(VideoType.NewRelease);
			romance.setReleasedYear(2020);
			romance.setAge(20);
			romance.setRate(15);
			videoRepository.save(romance);
		}

	}


}
