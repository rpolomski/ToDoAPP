import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Database.Job
import com.example.todoapp.R

class JobAdapter(
    private val onItemClicked: (Job) -> Unit
) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    private var jobList = listOf<Job>()

    class JobViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val bodyTextView: TextView = view.findViewById(R.id.bodyTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_job, parent, false)
        return JobViewHolder(view)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val job = jobList[position]
        holder.titleTextView.text = "${job.title}"
        holder.bodyTextView.text = "${job.body}"

        holder.itemView.setOnLongClickListener {
            onItemClicked(job)
            true
        }
    }

    override fun getItemCount(): Int = jobList.size

    fun submitList(jobs: List<Job>) {
        jobList = jobs
        notifyDataSetChanged() // Informuje adapter o zmianach w danych
    }
}
