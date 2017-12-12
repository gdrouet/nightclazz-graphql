import com.apollographql.apollo.compiler.GraphQLCompiler;
import com.apollographql.apollo.compiler.NullableValueType;

import java.io.File;
import java.util.Collections;

/**
 * Generates the "fragments" package and the {@code SearchQuery} class.
 * Make sure to have an up to date {@code operation-result-types.json} file generated with {@code apollo-codegen}.
 */
public class Generate {

    private static final String BASE_PATH = "apollo/java/src/main/graphql";

    public static void main(String[] args) {
        final GraphQLCompiler graphQLCompiler = new GraphQLCompiler();
        final File schema = new File(BASE_PATH + "/operation-result-types.json");
        final File out = new File(BASE_PATH);

        graphQLCompiler.write(new GraphQLCompiler.Arguments(
                schema, out, Collections.emptyMap(), NullableValueType.ANNOTATED, true, true)
        );
    }
}
