import { TestBed } from '@angular/core/testing';

import { sampleWithRequiredData, sampleWithNewData } from '../song.test-samples';

import { SongFormService } from './song-form.service';

describe('Song Form Service', () => {
  let service: SongFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SongFormService);
  });

  describe('Service methods', () => {
    describe('createSongFormGroup', () => {
      it('should create a new form with FormControl', () => {
        const formGroup = service.createSongFormGroup();

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            artistName: expect.any(Object),
            trackName: expect.any(Object),
            releaseDate: expect.any(Object),
            genre: expect.any(Object),
            lyrics: expect.any(Object),
            len: expect.any(Object),
            dating: expect.any(Object),
            violence: expect.any(Object),
            worldLife: expect.any(Object),
            nightTime: expect.any(Object),
            shakeTheAudience: expect.any(Object),
            familyGospel: expect.any(Object),
            romantic: expect.any(Object),
            communication: expect.any(Object),
            obscene: expect.any(Object),
            music: expect.any(Object),
            movementPlaces: expect.any(Object),
            lightVisualPerceptions: expect.any(Object),
            familySpiritual: expect.any(Object),
            likeGirls: expect.any(Object),
            sadness: expect.any(Object),
            feelings: expect.any(Object),
            danceability: expect.any(Object),
            loudness: expect.any(Object),
            acousticness: expect.any(Object),
            instrumentalness: expect.any(Object),
            valence: expect.any(Object),
            energy: expect.any(Object),
            topic: expect.any(Object),
            age: expect.any(Object),
          })
        );
      });

      it('passing ISong should create a new form with FormGroup', () => {
        const formGroup = service.createSongFormGroup(sampleWithRequiredData);

        expect(formGroup.controls).toEqual(
          expect.objectContaining({
            id: expect.any(Object),
            artistName: expect.any(Object),
            trackName: expect.any(Object),
            releaseDate: expect.any(Object),
            genre: expect.any(Object),
            lyrics: expect.any(Object),
            len: expect.any(Object),
            dating: expect.any(Object),
            violence: expect.any(Object),
            worldLife: expect.any(Object),
            nightTime: expect.any(Object),
            shakeTheAudience: expect.any(Object),
            familyGospel: expect.any(Object),
            romantic: expect.any(Object),
            communication: expect.any(Object),
            obscene: expect.any(Object),
            music: expect.any(Object),
            movementPlaces: expect.any(Object),
            lightVisualPerceptions: expect.any(Object),
            familySpiritual: expect.any(Object),
            likeGirls: expect.any(Object),
            sadness: expect.any(Object),
            feelings: expect.any(Object),
            danceability: expect.any(Object),
            loudness: expect.any(Object),
            acousticness: expect.any(Object),
            instrumentalness: expect.any(Object),
            valence: expect.any(Object),
            energy: expect.any(Object),
            topic: expect.any(Object),
            age: expect.any(Object),
          })
        );
      });
    });

    describe('getSong', () => {
      it('should return NewSong for default Song initial value', () => {
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        const formGroup = service.createSongFormGroup(sampleWithNewData);

        const song = service.getSong(formGroup) as any;

        expect(song).toMatchObject(sampleWithNewData);
      });

      it('should return NewSong for empty Song initial value', () => {
        const formGroup = service.createSongFormGroup();

        const song = service.getSong(formGroup) as any;

        expect(song).toMatchObject({});
      });

      it('should return ISong', () => {
        const formGroup = service.createSongFormGroup(sampleWithRequiredData);

        const song = service.getSong(formGroup) as any;

        expect(song).toMatchObject(sampleWithRequiredData);
      });
    });

    describe('resetForm', () => {
      it('passing ISong should not enable id FormControl', () => {
        const formGroup = service.createSongFormGroup();
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, sampleWithRequiredData);

        expect(formGroup.controls.id.disabled).toBe(true);
      });

      it('passing NewSong should disable id FormControl', () => {
        const formGroup = service.createSongFormGroup(sampleWithRequiredData);
        expect(formGroup.controls.id.disabled).toBe(true);

        service.resetForm(formGroup, { id: null });

        expect(formGroup.controls.id.disabled).toBe(true);
      });
    });
  });
});
