package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByAgeAndCity implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		if (o1.getCidade().equals(o2.getCidade()) && o1.getIdade() == o2.getIdade()) {
			return 0;
		}
		return 1;
	}

}
