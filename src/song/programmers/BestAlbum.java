package song.programmers;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
    public static void main(String[] args) {
        BestAlbum p = new BestAlbum();
        int[] answer = p.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        display(answer); // [4, 1, 3, 0]
    }

    private static void display(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    public int[] solution(String[] genres, int[] plays) {
        StreamingService service = new StreamingService();
        for (int i = 0; i < genres.length; i++) {
            service.play(new Song(i, genres[i], plays[i]));
        }
        return service.createBestAlbum();
    }

    private class StreamingService{
        private final Map<String, Integer> genreCountMap = new HashMap<>();
        private final Map<String, Queue<Song>> genreSongsMap = new HashMap<>();

        public void play(Song song){
            genreCountMap.put(song.genre, genreCountMap.getOrDefault(song.genre, 0) + song.playCount);

            Queue<Song> queue = genreSongsMap.getOrDefault(song.genre, new PriorityQueue<>());
            queue.add(song);
            genreSongsMap.put(song.genre, queue);
        }

        public int[] createBestAlbum() {
            List<String> genres = genreCountMap.entrySet()
                    .stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            List<Integer> bestAlbum = new ArrayList<>();
            for(String genre : genres){
                Queue<Song> songs = genreSongsMap.get(genre);
                int songCount = 0;
                while (!songs.isEmpty() && songCount < 2) {
                    bestAlbum.add(songs.poll().index);
                    songCount++;
                }
            }
            return bestAlbum.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }

    private class Song implements Comparable<Song>{
        private final int index;
        private final String genre;
        private final int playCount;

        public Song(int index, String genre, int playCount) {
            this.index = index;
            this.genre = genre;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(@NotNull Song o) {
            return this.playCount == o.playCount ? this.index - o.index : o.playCount - this.playCount;
        }
    }
}
/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (6.46ms, 71.5MB)
 * 테스트 2 〉	통과 (6.51ms, 69.4MB)
 * 테스트 3 〉	통과 (7.98ms, 80.7MB)
 * 테스트 4 〉	통과 (4.57ms, 75.4MB)
 * 테스트 5 〉	통과 (5.51ms, 78.2MB)
 * 테스트 6 〉	통과 (5.72ms, 88.5MB)
 * 테스트 7 〉	통과 (4.94ms, 84.6MB)
 * 테스트 8 〉	통과 (4.62ms, 74MB)
 * 테스트 9 〉	통과 (4.32ms, 74.2MB)
 * 테스트 10 〉	통과 (5.81ms, 79.2MB)
 * 테스트 11 〉	통과 (4.23ms, 78.6MB)
 * 테스트 12 〉	통과 (4.61ms, 78.8MB)
 * 테스트 13 〉	통과 (6.90ms, 72.1MB)
 * 테스트 14 〉	통과 (5.86ms, 82.8MB)
 * 테스트 15 〉	통과 (6.24ms, 73.2MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */