import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Performs the search query.
 */
public class Main extends ApolloCall.Callback<SearchQuery.Data> {
    public static void main(final String[] args) {
        final ApolloClient apolloClient = ApolloClient.builder()
                .serverUrl("http://localhost:4000/graphql")
                .build();
        final SearchQuery searchQuery = SearchQuery.builder()
                .query(Stream.of(args).collect(Collectors.joining(" ")))
                .build();

        apolloClient.query(searchQuery).enqueue(new Main());
    }

    @Override
    public void onResponse(@Nonnull final Response<SearchQuery.Data> response) {
        final SearchQuery.Data data = response.data();
        final String toString = data == null ? "" : data.toString();
        int tabs = 0;
        final char[] chars = toString.toCharArray();
        for (int i = 0; i < chars.length; i++ ) {
            char c = chars[i];
            switch (c) {
                case '{':
                    System.out.print(" " + c);
                    tabs += 4;
                    newLine(tabs);
                    break;
                case '}':
                    tabs -= 4;
                    newLine(tabs);
                    System.out.print(c);
                    break;
                case ',':
                    System.out.print(c);
                    newLine(tabs);
                    i++;
                    break;
                default:
                    System.out.print(c);
            }
        }
    }

    private void newLine(final int tabs) {
        System.out.print('\n');
        IntStream.iterate(0, j -> ++j)
                .limit(tabs)
                .forEach(j -> System.out.print(' '));
    }

    @Override
    public void onFailure(@Nonnull final ApolloException e) {
        e.printStackTrace();
    }
}
