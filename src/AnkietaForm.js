import React, { useState } from 'react';
import './AnkietaForm.css';

const AnkietaForm = () => {
  // State for the form fields
  const [fullName, setFullName] = useState('');
  const [indexNumber, setIndexNumber] = useState('');
  const [scheduleCompliance, setScheduleCompliance] = useState('');
  const [entryTest, setEntryTest] = useState('');
  const [preparationTime, setPreparationTime] = useState('');
  const [topicRelevance, setTopicRelevance] = useState('');
  const [topicExplained, setTopicExplained] = useState('');
  const [interactive, setInteractive] = useState('');
  const [instructorRating, setInstructorRating] = useState('');
  const [teachingMethods, setTeachingMethods] = useState('');
  const [overallAtmosphere, setOverallAtmosphere] = useState('');
  const [educationalMaterial, setEducationalMaterial] = useState('');

  // Handle form submission
  const handleSubmit = (event) => {
    event.preventDefault();
    const formData = {
      fullName,
      indexNumber,
      scheduleCompliance,
      entryTest,
      preparationTime,
      topicRelevance,
      topicExplained,
      interactive,
      instructorRating,
      teachingMethods,
      overallAtmosphere,
      educationalMaterial
    };
    console.log(formData);
    // Send formData to server or process it as required
  };

  return (
    <div className="ankieta-container">
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Imię i nazwisko</label>
          <input type="text" value={fullName} onChange={(e) => setFullName(e.target.value)} />
        </div>

        <div className="form-group">
          <label>Numer indeksu</label>
          <input type="text" value={indexNumber} onChange={(e) => setIndexNumber(e.target.value)} />
        </div>

        {/* Radio button questions */}
        <div className="form-group">
          <label>Czy zajęcia rozpoczęły się i zakończyły zgodnie z planem zajęć?</label>
          <label>
            <input type="radio" name="scheduleCompliance" value="yes" checked={scheduleCompliance === 'yes'} onChange={(e) => setScheduleCompliance(e.target.value)} />
            Tak
          </label>
          <label>
            <input type="radio" name="scheduleCompliance" value="no" checked={scheduleCompliance === 'no'} onChange={(e) => setScheduleCompliance(e.target.value)} />
            Nie
          </label>
        </div>

        <div className="form-group">
          <label>Czy na zajęciach odbył się test wejściowy?</label>
          <label>
            <input type="radio" name="entryTest" value="yes" checked={entryTest === 'yes'} onChange={(e) => setEntryTest(e.target.value)} />
            Tak
          </label>
          <label>
            <input type="radio" name="entryTest" value="no" checked={entryTest === 'no'} onChange={(e) => setEntryTest(e.target.value)} />
            Nie
          </label>
        </div>

        {/* Text input questions */}
        <div className="form-group">
          <label>Jak długo czasu poświęciłeś na przygotowanie się do zajęć?</label>
          <input type="text" value={preparationTime} onChange={(e) => setPreparationTime(e.target.value)} />
        </div>

        <div className="form-group">
          <label>Jak oceniasz przydatność tematu zajęć?</label>
          <input type="text" value={topicRelevance} onChange={(e) => setTopicRelevance(e.target.value)} />
        </div>

        {/* More radio button questions */}
        <div className="form-group">
          <label>Czy temat zajęć był uprzednio w pełni wyjaśniony na wykładzie?</label>
          <label>
            <input type="radio" name="topicExplained" value="yes" checked={topicExplained === 'yes'} onChange={(e) => setTopicExplained(e.target.value)} />
            Tak
          </label>
          <label>
            <input type="radio" name="topicExplained" value="no" checked={topicExplained === 'no'} onChange={(e) => setTopicExplained(e.target.value)} />
            Nie
          </label>
        </div>

        <div className="form-group">
          <label>Czy zajęcia prowadzone były w sposób interaktywny we współpracy ze studentami?</label>
          <label>
            <input type="radio" name="interactive" value="yes" checked={interactive === 'yes'} onChange={(e) => setInteractive(e.target.value)} />
            Tak
          </label>
          <label>
            <input type="radio" name="interactive" value="no" checked={interactive === 'no'} onChange={(e) => setInteractive(e.target.value)} />
            Nie
          </label>
        </div>

        {/* Text input questions */}
        <div className="form-group">
          <label>Jak oceniasz prowadzenie zajęć przez prowadzącego?</label>
          <input type="text" value={instructorRating} onChange={(e) => setInstructorRating(e.target.value)} />
        </div>

        {/* More radio button questions */}
        <div className="form-group">
          <label>Czy metody nauczania były adekwatne do tematu zajęć?</label>
          <label>
            <input type="radio" name="teachingMethods" value="yes" checked={teachingMethods === 'yes'} onChange={(e) => setTeachingMethods(e.target.value)} />
            Tak
          </label>
          <label>
            <input type="radio" name="teachingMethods" value="no" checked={teachingMethods === 'no'} onChange={(e) => setTeachingMethods(e.target.value)} />
            Nie
          </label>
        </div>

        <div className="form-group">
          <label>Jak oceniasz ogólną atmosferę podczas zajęć?</label>
          <label>
            <input type="radio" name="overallAtmosphere" value="yes" checked={overallAtmosphere === 'yes'} onChange={(e) => setOverallAtmosphere(e.target.value)} />
            Dobrze
          </label>
          <label>
            <input type="radio" name="overallAtmosphere" value="no" checked={overallAtmosphere === 'no'} onChange={(e) => setOverallAtmosphere(e.target.value)} />
            Źle
          </label>
        </div>

        <div className="form-group">
          <label>Czy materiały dydaktyczne były pomocne?</label>
          <label>
            <input type="radio" name="educationalMaterial" value="yes" checked={educationalMaterial === 'yes'} onChange={(e) => setEducationalMaterial(e.target.value)} />
            Tak
          </label>
          <label>
            <input type="radio" name="educationalMaterial" value="no" checked={educationalMaterial === 'no'} onChange={(e) => setEducationalMaterial(e.target.value)} />
            Nie
          </label>
        </div>

        <div className="form-group">
          <button type="submit">Wyślij formularz</button>
        </div>
      </form>
    </div>
  );
};

export default AnkietaForm;
