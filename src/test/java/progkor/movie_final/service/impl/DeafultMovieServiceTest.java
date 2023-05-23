package progkor.movie_final.service.impl;

/*
*  Test for DefaultMovieService
* */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import progkor.movie_final.data.model.Genre;
import progkor.movie_final.data.model.Movie;
import progkor.movie_final.data.repository.Repository;
import progkor.movie_final.service.MovieService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class DeafultMovieServiceTest {

    private static final Long SOME_MOVIE_ID = 1L;
    private static final Movie SOME_MOVIE = new Movie(1L,"randomTitle","unknownDirector",2025,18, Genre.ACTION);

    @Mock
    private Repository<Movie, Long> movieRepository;

    private MovieService underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
        underTest = new DeafultMovieService(movieRepository);
    }

    @Test
    void createMovieShouldDelegateToRepositoryAndReturnSavedMovie() {
        given(movieRepository.save(SOME_MOVIE)).willReturn(SOME_MOVIE); 

        final Movie supposedToReturn = underTest.createMovie(SOME_MOVIE);

        assertThat(supposedToReturn, equalTo(SOME_MOVIE)); 

        verify(movieRepository).save(SOME_MOVIE); 
        verifyNoMoreInteractions(movieRepository); 
    }


    @Test
    void retrieveByMovieId() {
    }

    @Test
    void retrieveAllMovie() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteMovieById() {
    }
}
