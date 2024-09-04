package com.ltp.gradesubmission;

import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradesFromRepoTest() {
        // Arrange
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
                        new Grade("Yumer", "Math", "A"),
                        new Grade("Lolo", "Bio", "A+")
                )
        );

        //Act
        List<Grade> grades = gradeService.getGrades();

        //Assert
        assertEquals("Yumer", grades.get(0).getName());
        assertEquals("Lolo", grades.get(1).getName());
    }

    @Test
    public void getGradeIndexByIdTest() {
        //Arrange
        Grade grade = new Grade("Lolo", "Bio", "A+");
        when(gradeRepository.getGrades()).thenReturn(List.of(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        // Act
        var found_index = gradeService.getGradeIndexById(grade.getId());
        var index_not_found = gradeService.getGradeIndexById("cvxvcvx");

        // Assert
        assertEquals(index_not_found, Constants.NOT_FOUND);
        assertEquals(found_index, 0);
    }

    @Test
    public void getGradeByIdTest() {
        //Arrange
        Grade grade = new Grade("Lolo", "Bio", "A+");
        String id = grade.getId();
        when(gradeRepository.getGrades()).thenReturn(List.of(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);

        //Act
        var result = gradeService.getGradeById(id);

        //Assert
        assertEquals(grade, result);
    }

    @Test
    public void submitGradeTest() {
        //Arrange
        Grade grade = new Grade("Lolo", "Bio", "A+");
        when(gradeRepository.getGrades()).thenReturn(List.of(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);
        var newGrade = new Grade("Yumer", "Math", "A");

        //Act
        gradeService.submitGrade(newGrade);

        //Assert
        verify(gradeRepository, times(1)).addGrade(newGrade);
    }

    @Test
    public void updateGradeTest() {
        //Arrange
        Grade grade = new Grade("Lolo", "Bio", "A+");
        when(gradeRepository.getGrades()).thenReturn(List.of(grade));
        when(gradeRepository.getGrade(0)).thenReturn(grade);
        var newGrade = new Grade("Yumer", "Math", "A");

        //Act
        gradeService.submitGrade(grade);

        //Assert
        verify(gradeRepository, times(1)).updateGrade(0, grade);
        verify(gradeRepository, times(0)).addGrade(newGrade);
    }
}