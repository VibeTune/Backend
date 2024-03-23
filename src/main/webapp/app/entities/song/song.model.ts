export interface ISong {
  id: number;
  artistName?: string | null;
  trackName?: string | null;
  releaseDate?: number | null;
  genre?: string | null;
  lyrics?: string | null;
  len?: number | null;
  dating?: number | null;
  violence?: number | null;
  worldLife?: number | null;
  nightTime?: number | null;
  shakeTheAudience?: number | null;
  familyGospel?: number | null;
  romantic?: number | null;
  communication?: number | null;
  obscene?: number | null;
  music?: number | null;
  movementPlaces?: number | null;
  lightVisualPerceptions?: number | null;
  familySpiritual?: number | null;
  likeGirls?: number | null;
  sadness?: number | null;
  feelings?: number | null;
  danceability?: number | null;
  loudness?: number | null;
  acousticness?: number | null;
  instrumentalness?: number | null;
  valence?: number | null;
  energy?: number | null;
  topic?: string | null;
  age?: number | null;
}

export type NewSong = Omit<ISong, 'id'> & { id: null };
